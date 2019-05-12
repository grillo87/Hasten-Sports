package com.josegrillo.hastensports.mapperTest

import com.josegrillo.hastensports.domain.models.api.PlayersModel
import com.josegrillo.hastensports.domain.models.mappers.playerModelToPlayerView
import org.junit.Assert
import org.junit.Test

class PlayersMapperTest {

    @Test
    fun mapPlayerModelToPlayerView(){

        val playersModel = PlayersModel("http://www.segundoasegundo.com/sas/wp-content/uploads/2014/01/cristiano-ronaldo.jpg", "Ronaldo", "Cristiano")
        val player = playersModel.playerModelToPlayerView()

        Assert.assertEquals(playersModel.name, player.name)
        Assert.assertEquals(playersModel.surname, player.surName)
        Assert.assertEquals(playersModel.image, player.image)


    }


}