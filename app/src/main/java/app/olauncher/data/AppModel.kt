package app.olauncher.data

import android.graphics.drawable.Drawable
import android.os.UserHandle
import java.text.CollationKey

data class AppModel(
    val appLabel: String,
    val key: CollationKey?,
//    增加应用图标
    val appIcon: Drawable?,
    val appPackage: String,
    val activityClassName: String?,
    val isNew: Boolean? = false,
    val user: UserHandle,
) : Comparable<AppModel> {
    override fun compareTo(other: AppModel): Int = when {
        key != null && other.key != null -> key.compareTo(other.key)
        else -> appLabel.compareTo(other.appLabel, true)
    }
}