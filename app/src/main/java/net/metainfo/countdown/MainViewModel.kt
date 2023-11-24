package net.metainfo.countdown

import android.content.ContentValues.TAG
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    var _uiStateFlow = MutableStateFlow<Long>(0L)
    val uiState = _uiStateFlow.asStateFlow()

    lateinit var timer: Timer

    fun setTimer(min: Int, sec: Int) {
        timer = Timer(min, sec, 1000L, _uiStateFlow)
    }

    fun start() {
        timer.start()
    }
}

class Timer(
    min: Int,
    sec: Int,
    interval: Long = 1000L,
    val state: MutableStateFlow<Long>
): CountDownTimer(min * 60000L + sec * 1000L, interval) {

    private var remain: Long = 0

    override fun onTick(millisUntilFinished: Long) {
        remain = millisUntilFinished
        Log.d(TAG, "onTick: ${remain} - ${millisUntilFinished}")
        state.update {
            millisUntilFinished
        }
    }

    override fun onFinish() {
        Log.d(TAG, "onFinish: ${remain}")
        state.update {
            remain
        }
    }


}

