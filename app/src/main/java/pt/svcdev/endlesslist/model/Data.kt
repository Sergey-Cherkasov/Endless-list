package pt.svcdev.endlesslist.model

import com.google.gson.annotations.Expose

data class Data(
    @Expose val after: String,
    @Expose val children: List<Child>
)