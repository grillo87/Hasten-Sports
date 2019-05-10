package com.josegrillo.hastensports.apitest

import com.josegrillo.cabifydemo.utils.getResponseFromJson
import com.josegrillo.cabifydemo.utils.queueResponse
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class GetSportsTest : BaseApiTest() {

    @Test
    fun getSportsList() {


        mockWebServer.queueResponse {
            setResponseCode(200)
            setBody("sports".getResponseFromJson())
        }


        appApi
            .getSportsList()
            .test()
            .run {

                values().let {

                    assertNoErrors()
                    Assert.assertEquals(it[0][0].title, "Football")
                    Assert.assertEquals(it[0][1].type, "GRID")
                    Assert.assertEquals(it[0][2].players.size, 10)
                    Assert.assertEquals(it[0][3].players[0].image, "http://www.lanuevanoticia.com/wp-content/uploads/2013/11/Sebastian-Vettel.jpg")
                    Assert.assertEquals(it[0][3].players[1].surname, "Alonso")
                    Assert.assertEquals(it[0][3].players[2].name, "Lewis")


                }
            }


    }

}