package com.tinkoff.android_homework.presentation.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinkoff.android_homework.domain.main.usecases.SubscribeDetailUseCase
import com.tinkoff.android_homework.presentation.model.DetailItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val subscribeDetailUseCase: SubscribeDetailUseCase,
) : ViewModel() {

    private val _details: MutableStateFlow<DetailItem?> = MutableStateFlow(null)
    val details: StateFlow<DetailItem?> = _details.asStateFlow()

    init {
        viewModelScope.launch {
            val detail = subscribeDetailUseCase.getDetail(0)
            Log.e("TAGRTRT", "detail :${detail}")
        }
    }
}
