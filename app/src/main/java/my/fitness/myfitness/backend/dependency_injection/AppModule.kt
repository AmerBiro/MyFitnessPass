package my.fitness.myfitness.backend.dependency_injection

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import my.fitness.myfitness.backend.data.local.database.ProgramDatabase
import my.fitness.myfitness.backend.Constants.BASE_URL
import my.fitness.myfitness.backend.Constants.DATABASE_NAME
import my.fitness.myfitness.backend.Constants.ENCRYPTED_SHARED_PREF_NAME
import my.fitness.myfitness.backend.data.remote.api.ProgramAPI
import my.fitness.myfitness.backend.data.remote.interceptor.BasicAuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideProgramsDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ProgramDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideProgramDao(db: ProgramDatabase) = db.programDao()

    @Singleton
    @Provides
    fun provideBasicAuthInterceptor() = BasicAuthInterceptor()


    @Singleton
    @Provides
    fun provideProgramAPI(
        basicAuthInterceptor: BasicAuthInterceptor
    ): ProgramAPI {
        val client = OkHttpClient.Builder()
            .addInterceptor(basicAuthInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ProgramAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideEncryptedSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        return EncryptedSharedPreferences.create(
            context,
            ENCRYPTED_SHARED_PREF_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }



}