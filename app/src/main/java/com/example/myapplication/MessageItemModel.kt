package com.example.myapplication

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.*
import com.example.myapplication.Message

@EpoxyModelClass(layout = R.layout.view_holder_message_item)
abstract class MessageItemModel: EpoxyModelWithHolder<MessageItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var message: Message

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(message) {
            holder.title.text = username
            holder.content.text = content
        }



    }


    class Holder : EpoxyHolder() {

        lateinit var profileImage: ImageView
        lateinit var title: AppCompatTextView
        lateinit var content: AppCompatTextView

        override fun bindView(itemView: View) {
            profileImage = itemView.findViewById(R.id.message_profile_image)
            title = itemView.findViewById(R.id.message_profile_name)
            content = itemView.findViewById(R.id.message_content)
        }
    }
}