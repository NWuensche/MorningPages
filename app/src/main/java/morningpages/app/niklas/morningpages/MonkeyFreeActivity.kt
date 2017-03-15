package morningpages.app.niklas.morningpages

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MonkeyFreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monkey_free)
    }

    override fun onBackPressed() {
        val intent: Intent = Intent(this, TimerActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        this.startActivity(intent)
        return
    }
}
