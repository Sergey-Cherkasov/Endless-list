package pt.svcdev.endlesslist.model

import com.google.gson.annotations.Expose

data class DataChild(
    @Expose val title: String,
    @Expose val sefltext: String
)