package morningpages.app.niklas.morningpages

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.menu.ActionMenuItemView
import android.view.Menu
import rx.android.schedulers.AndroidSchedulers
import rx.subjects.PublishSubject

class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_write, menu)
        menu!!.findItem(R.id.show_timer).title = intent.extras.getString("time")
        return super.onCreateOptionsMenu(menu)
    }

    //TODO First time, not other times.
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        val item = findViewById(R.id.show_timer) as ActionMenuItemView
        val times = CurrTime.formatTimeAndCreateList(intent.extras.getString("time"))
        PublishSubject.interval(1, java.util.concurrent.TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .take(times.size)
                .subscribe({item.text = times[it.toInt()]}, {}, {item.text = "Fertig"})

        super.onWindowFocusChanged(hasFocus)
    }
}
