package com.josegrillo.hastensports.mapperTest

import com.josegrillo.hastensports.domain.models.api.PlayersModel
import com.josegrillo.hastensports.domain.models.api.SportsModel
import com.josegrillo.hastensports.domain.models.mappers.playerModelToPlayerView
import com.josegrillo.hastensports.domain.models.mappers.sportModelToSportView
import com.josegrillo.hastensports.views.models.Sport
import org.junit.Assert
import org.junit.Test

class SportsMapperTest {

    @Test
    fun mapSportModelToSportView(){

        val cristianoModel = PlayersModel("http://www.segundoasegundo.com/sas/wp-content/uploads/2014/01/cristiano-ronaldo.jpg", "Ronaldo", "Cristiano")
        val messiModel = PlayersModel("http://1.bp.blogspot.com/-YGMAme-l8DQ/T6fJARFRgAI/AAAAAAAAAj8/0cB5NiT4R5Q/s320/lionel-messi-2011-2-5-18-11-2.jpg", "Messi", "Lionel")
        val casillasModel = PlayersModel("http://gritasports.com.mx/wp-content/uploads/2013/01/Iker_Casillas5.jpg", "Casillas", "Iker")


        val playersList = ArrayList<PlayersModel>()
        playersList.add(cristianoModel)
        playersList.add(messiModel)
        playersList.add(casillasModel)

        val sportModel = SportsModel(playersList, "LIST_A", "Football")
        val sport = sportModel.sportModelToSportView()

        Assert.assertEquals(sport.name, sportModel.title)
        Assert.assertEquals(sport.players.size, 3)
        Assert.assertEquals(sport.players[0].image, cristianoModel.image)
        Assert.assertEquals(sport.players[1].surName, messiModel.surname)
        Assert.assertEquals(sport.players[2].name, casillasModel.name)




    }

}