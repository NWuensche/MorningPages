package morningpages.app.niklas.morningpages

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val self = this

        text0.setOnClickListener { v -> v.startAnimation(AnimationUtils.loadAnimation(v.context,R.anim.animation))
            ClickAndChangeListener.onClickText(self, "0") }
        text1.setOnClickListener { v -> v.startAnimation(AnimationUtils.loadAnimation(v.context,R.anim.animation))
             ClickAndChangeListener.onClickText(self, "1") }
        text2.setOnClickListener { v -> v.startAnimation(AnimationUtils.loadAnimation(v.context,R.anim.animation))
             ClickAndChangeListener.onClickText(self, "2") }
        text3.setOnClickListener { v -> v.startAnimation(AnimationUtils.loadAnimation(v.context,R.anim.animation))
             ClickAndChangeListener.onClickText(self, "3") }
        text4.setOnClickListener { v -> v.startAnimation(AnimationUtils.loadAnimation(v.context,R.anim.animation))
             ClickAndChangeListener.onClickText(self, "4") }
        text5.setOnClickListener { v -> v.startAnimation(AnimationUtils.loadAnimation(v.context,R.anim.animation))
             ClickAndChangeListener.onClickText(self, "5") }
        text6.setOnClickListener { v -> v.startAnimation(AnimationUtils.loadAnimation(v.context,R.anim.animation))
             ClickAndChangeListener.onClickText(self, "6") }
        text7.setOnClickListener { v -> v.startAnimation(AnimationUtils.loadAnimation(v.context,R.anim.animation))
             ClickAndChangeListener.onClickText(self, "7") }
        text8.setOnClickListener { v -> v.startAnimation(AnimationUtils.loadAnimation(v.context,R.anim.animation))
             ClickAndChangeListener.onClickText(self, "8") }
        text9.setOnClickListener { v -> v.startAnimation(AnimationUtils.loadAnimation(v.context,R.anim.animation))
             ClickAndChangeListener.onClickText(self, "9") }

        deleteLastNumber.setOnClickListener { _ -> ClickAndChangeListener.onClickDelete(self) }
        startTimer.setOnClickListener { _ -> ClickAndChangeListener.switchToWriteActivity(self) }
    }

}
