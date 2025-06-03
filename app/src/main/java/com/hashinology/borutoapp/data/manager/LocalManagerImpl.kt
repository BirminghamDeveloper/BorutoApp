package com.hashinology.borutoapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.hashinology.borutoapp.utils.Constants.PREFERENCES_KEY
import com.hashinology.borutoapp.utils.Constants.PREFERENCES_NAME
import com.hashinology.domain.manager.LocalManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

// create extension variable will be used to access the Data Store
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class DataStoreOperationsImpl(context: Context): LocalManager {

    // Below will use to tell out datastore library under which name key that the boolean value will be stored
    private object PreferenceKey{
        val onBoardingKey = booleanPreferencesKey(name = PREFERENCES_KEY)
    }

    /*
    this variable is the instance of our datastore which will need to save that value locally,
    coz its hold the datastore that extended variable
    which already made above which have the datastore name,
     */
    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(completed: Boolean) {
        /*
        to save a simple value in to our dataStore preference,
        by call the datastore.edit which presist that value by using the key
         */
        dataStore.edit { preferences ->
            preferences[PreferenceKey.onBoardingKey] = completed
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        // read the value from saveOnBoardingState() key
        return dataStore.data
            .catch { exception ->
                if (exception is IOException){
                    emit(emptyPreferences())
                }else{
                    throw exception
                }
            }
            .map {  preferences ->
                val onBoardingState = preferences[PreferenceKey.onBoardingKey] ?: false
                onBoardingState
            }
    }
}