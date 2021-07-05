package pt.svcdev.endlesslist.model

import com.google.gson.annotations.Expose

data class Child(
    @Expose val kind: String,
    @Expose val data: DataChild
)