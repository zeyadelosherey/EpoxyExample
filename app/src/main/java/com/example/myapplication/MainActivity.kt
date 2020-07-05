package com.example.myapplication
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.OnModelBuildFinishedListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val controller = HomeController(selectionListener)

        controller.allMessages =Data.messages.toMutableList()
        controller.recentlyActive = Data.recentlyActive.toMutableList()


        messagesView.setLayoutManager(GridLayoutManager(this, 3))
        messagesView.setController(controller)

        clicked.setOnClickListener {
            controller.loadingPromotion = !controller.loadingPromotion
            controller.allMessages.addAll(Data.messages )
            messagesView.post {
                messagesView.smoothScrollToPosition(0)
            }
        }

    }

    private val selectionListener: (String) -> Unit = {
        Log.e("MAIN" , it)
    }

}
