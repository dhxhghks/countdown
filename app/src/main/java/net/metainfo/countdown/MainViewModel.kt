package net.metainfo.countdown

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var timer = Timer()


    fun start() {
        timer.start()
    }
}

class Timer {
    private lateinit var t: CountDownTimer

    fun setTimer(min: Int, sec: Int) {
        t = object: CountDownTimer(10000, 100) {
            override fun onTick(p0: Long) {
                TODO("Not yet implemented")
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }
        }
    }

    fun start() {
        t.start()
    }

}

