package com.dekola.dekoladepoptest.characters.data.model

import com.google.gson.annotations.SerializedName

data class CharacterDTO(

	@field:SerializedName("Status")
	val status: String? = null,

	@field:SerializedName("VoicedBy")
	val voicedBy: String? = null,

	@field:SerializedName("Profession")
	val profession: String? = null,

	@field:SerializedName("FirstAppearance")
	val firstAppearance: String? = null,

	@field:SerializedName("Relatives")
	val relatives: String? = null,

	@field:SerializedName("Planet")
	val planet: String? = null,

	@field:SerializedName("PicUrl")
	val picUrl: String? = null,

	@field:SerializedName("Species")
	val species: String? = null,

	@field:SerializedName("Age")
	val age: String? = null,

	@field:SerializedName("Name")
	val name: String? = null
)
