package com.dineshprabha.tweetsy.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dineshprabha.tweetsy.models.Tweet
import com.dineshprabha.tweetsy.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: TweetRepository,
    private val savedStateHandle : SavedStateHandle
) : ViewModel() {
    val tweets: StateFlow<List<Tweet>>
        get() = repository.tweets

    init {

        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "motivation"
            repository.getTweets(category)
        }
    }
}