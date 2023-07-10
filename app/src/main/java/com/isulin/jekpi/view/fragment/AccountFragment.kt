package com.isulin.jekpi.view.fragment

import android.annotation.SuppressLint
import android.app.Notification
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.FragmentAccountBinding
import com.isulin.jekpi.view.notification.BaseApplication

class AccountFragment : Fragment() {
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!
    private lateinit var notificationManager: NotificationManagerCompat
    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val view = binding.root

        notificationManager = NotificationManagerCompat.from(requireContext())

        if (binding.scNotificationFragmentAccount.isChecked){
            val title: String = "Jekpi - Jejak Pikiran"
            val desc: String = "Hari ini kamu belum nulis loh, yuk buka aplikasimu!"
            val builder = NotificationCompat.Builder(requireContext(), BaseApplication.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.jekpi_icon)
                .setContentTitle(title)
                .setContentText(desc)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)

            val notification: Notification = builder.build()
            this.notificationManager.notify(1, notification)
        }

        return view
    }
}