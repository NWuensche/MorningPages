package morningpages.app.niklas.morningpages

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.menu.ActionMenuItemView
import android.view.Menu
import android.view.inputmethod.InputMethodManager
import rx.android.schedulers.AndroidSchedulers
import rx.subjects.PublishSubject


class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_write, menu)
        menu!!.findItem(R.id.show_timer).title = CurrTime.formatTime(intent.extras.getString("time")).toString() // TODO Test -> 00:60:00 -> 00:01:00
        return super.onCreateOptionsMenu(menu)
    }

    //TODO First time, not other times.
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        val item = findViewById(R.id.show_timer) as ActionMenuItemView
        val times = CurrTime.formatTimeAndCreateList(intent.extras.getString("time")).drop(1) // Takes some time, so start with already ticked
        PublishSubject.interval(1, java.util.concurrent.TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .take(times.size)
                .subscribe({item.text = times[it.toInt()]}, {}, {onCompleted()})

        super.onWindowFocusChanged(hasFocus)
    }

    private fun onCompleted() {
        val item = findViewById(R.id.show_timer) as ActionMenuItemView
        item.text = "Fertig"

        val inputManager = applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(item.windowToken, 0)
    }

    override fun onBackPressed() {
        return
    }
    
}
