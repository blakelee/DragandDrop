package net.blakelee.draganddrop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.motion_02.*

class MainActivity : AppCompatActivity() {

    private val enabled: () -> Unit = {
        motionLayout.setTransition(R.id.start, R.id.end)
        cancelAction = disabled
    }

    private val disabled: () -> Unit = {
        motionLayout.setTransition(R.id.start, R.id.start)
        cancelAction = enabled
    }

    private var cancelAction: () -> Unit = disabled

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion_02)

        cancel.setOnClickListener {
            motionLayout.transitionToStart()
            cancelAction()
        }
    }
}
