package pt.svcdev.endlesslist.model

import com.google.gson.annotations.Expose

data class Listing(
    @Expose val kind: String,
    @Expose val data: Data
)