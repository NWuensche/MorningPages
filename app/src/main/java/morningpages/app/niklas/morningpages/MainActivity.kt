package morningpages.app.niklas.morningpages

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val self = this

        text0.setOnClickListener { _ -> ClickListener.onClickText(self, "0") }
        text1.setOnClickListener { _ -> ClickListener.onClickText(self, "1") }
        text2.setOnClickListener { _ -> ClickListener.onClickText(self, "2") }
        text3.setOnClickListener { _ -> ClickListener.onClickText(self, "3") }
        text4.setOnClickListener { _ -> ClickListener.onClickText(self, "4") }
        text5.setOnClickListener { _ -> ClickListener.onClickText(self, "5") }
        text6.setOnClickListener { _ -> ClickListener.onClickText(self, "6") }
        text7.setOnClickListener { _ -> ClickListener.onClickText(self, "7") }
        text8.setOnClickListener { _ -> ClickListener.onClickText(self, "8") }
        text9.setOnClickListener { _ -> ClickListener.onClickText(self, "9") }

        deleteLastNumber.setOnClickListener { _ -> ClickListener.onClickDelete(self) }
        startTimer.setOnClickListener { _ -> ClickListener.switchToWriteActivity(self) }
    }

}
