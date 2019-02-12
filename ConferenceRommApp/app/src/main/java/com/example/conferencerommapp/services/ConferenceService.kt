package com.example.conferencerommapp.services

import com.example.conferencerommapp.Model.Building
import com.example.conferencerommapp.Model.ConferenceRoom
import retrofit2.Call
import retrofit2.http.*

interface ConferenceService  {

    @GET("api/building")
    fun getBuildingList() : Call<List<Building>>

    @GET("api/Conference/{id}")
    fun getConferenceRoomList(@Path("id")id: Int) : Call<List<ConferenceRoom>>

    //@GET("destination")
    //fun getDestinationList(@Query( "country") country : String?, @Query("counnt") count: Int) : Call<List<Destination>>

    /*@GET("destination")
    fun getDestinationList(@QueryMap filter: HashMap<String, String>) : Call<List<Destination>>

    @GET("destination/{id}")
    fun getDestination(@Path("id") id: Int) : Call<Destination>

    @POST("destination")
    fun addDestination(@Body newDestination: Destination) : Call<Destination>

    @FormUrlEncoded
    @PUT("destination/{id}")
    fun updateDestination(
        @Path("id") id: Int,
        @Field("city") city: String,
        @Field("description") desc: String,
        @Field("country") country: String
    ) : Call<Destination>

    @DELETE("destination/{id}")
    fun deleteDestination(@Path("id") id: Int) : Call<Unit>
*/
}