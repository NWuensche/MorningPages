package morningpages.app.niklas.morningpages

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.menu.ActionMenuItemView
import android.util.Log
import android.view.Menu
import rx.Observable
import rx.lang.kotlin.subscribeBy
import rx.schedulers.Schedulers
import rx.subjects.PublishSubject
import rx.subjects.ReplaySubject

class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_write, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //TODO First time, not other times.
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        val item = findViewById(R.id.show_timer) as ActionMenuItemView
        //val times = CurrTime.formatTimeAndCreateList(intent.extras.getString("time"))
        PublishSubject.interval(1, java.util.concurrent.TimeUnit.SECONDS, Schedulers.newThread())
                .subscribeBy(onNext = {item.text = it.toString()})

        super.onWindowFocusChanged(hasFocus)

    }
}
