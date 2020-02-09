package com.treeengineering.core.ext

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

class ManifestUtil(context: Context) {
    private val applicationInfo: ApplicationInfo = context.packageManager.getApplicationInfo(
        context.packageName,
        PackageManager.GET_META_DATA
    )

    fun getClientId() = applicationInfo.metaData.getString("CLIENT_ID")

    fun getClientSecret() = applicationInfo.metaData.getString("CLIENT_SECRET")
}
