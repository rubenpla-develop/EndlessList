package rubenpla.develop.endlesslist.entity

import com.google.gson.annotations.SerializedName

data class Owner(

		@SerializedName("login") val login: String,
		@SerializedName("html_url") val htmlUrl: String
)