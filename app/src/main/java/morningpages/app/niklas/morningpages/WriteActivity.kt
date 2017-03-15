package morningpages.app.niklas.morningpages

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.menu.ActionMenuItemView
import android.view.Menu
import android.view.inputmethod.InputMethodManager
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.subjects.PublishSubject


class WriteActivity : AppCompatActivity() {

    var firstTime = true
    var monkeyFree = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_write, menu)
        menu!!.findItem(R.id.show_timer).title = CurrTime.formatTime(intent.extras.getString("time")).toString()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if(firstTime && hasFocus) {
            val item = findViewById(R.id.show_timer) as ActionMenuItemView
            val times = CurrTime.formatTimeAndCreateList(intent.extras.getString("time")).drop(1) // Takes some time, so start with already ticked
            PublishSubject.interval(1, java.util.concurrent.TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                    .take(times.size)
                    .takeUntil { monkeyFree }
                    .subscribe({item.text = times[it.toInt()]}, {}, {if(!monkeyFree) onCompleted()})

            firstTime = false
        }
        else if(!firstTime && hasFocus) {
            ClickAndChangeListener.switchToMonkeyFreeActivity(this)
            monkeyFree = true
        }

        super.onWindowFocusChanged(hasFocus)
    }

    private fun onCompleted() {
        val item = findViewById(R.id.show_timer) as ActionMenuItemView
        item.text = "00:00:00"

        val inputManager = applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(item.windowToken, 0)

        ClickAndChangeListener.switchToFinishedActivity(this)
    }

    override fun onBackPressed() {
        return
    }

}
