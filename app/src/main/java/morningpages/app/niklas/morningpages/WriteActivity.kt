package morningpages.app.niklas.morningpages

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.menu.ActionMenuItemView
import android.view.Menu
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subjects.PublishSubject

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
        PublishSubject.interval(1, java.util.concurrent.TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({item.text = it.toString()})

        super.onWindowFocusChanged(hasFocus)
    }
}
