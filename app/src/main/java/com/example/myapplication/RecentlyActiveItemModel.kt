package com.example.myapplication

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder


@EpoxyModelClass(layout = R.layout.view_holder_recently_active_item)
abstract class RecentlyActiveItemModel( private val listener: (String) -> Unit) : EpoxyModelWithHolder<RecentlyActiveItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var profile: Profile

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(profile) {
            holder.profileName.text = name
            holder.lastSeen.text = lastSeen

            holder.profileImage.setOnClickListener {

               listener.invoke(name)
            }
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var profileImage: ImageView
        lateinit var profileName: AppCompatTextView
        lateinit var lastSeen: AppCompatTextView

        override fun bindView(itemView: View) {
            profileImage = itemView.findViewById(R.id.recently_added_profile_image)
            profileName = itemView.findViewById(R.id.recently_added_profile_name)
            lastSeen = itemView.findViewById(R.id.recently_added_last_seen)

        }
    }
}