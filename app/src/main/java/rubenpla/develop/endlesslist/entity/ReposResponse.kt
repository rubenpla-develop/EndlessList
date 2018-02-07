package rubenpla.develop.endlesslist.entity

import com.google.gson.annotations.SerializedName

data class RepoApi(

		@SerializedName("id") val id: Int,
		@SerializedName("name") val name: String,
		@SerializedName("owner") val owner: Owner,
		@SerializedName("html_url") val htmlUrl: String,
		@SerializedName("description") val description: String?,
		@SerializedName("fork") val fork: Boolean
)

