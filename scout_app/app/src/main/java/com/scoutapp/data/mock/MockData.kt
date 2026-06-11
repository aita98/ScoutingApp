package com.scoutapp.data.mock

import com.scoutapp.data.api.PlayerResponse
import com.scoutapp.data.api.RadarResponse
import com.scoutapp.data.api.SeasonStats
import com.scoutapp.data.api.ScoutEventResponse

object MockData {
    val players = listOf(
        PlayerResponse(1, "1110474", "Lamine Yamal", "FC Barcelona", 16, 120000000.0, 92.0, 40.0, "RW", "https://feeds.abplive.com/onecms/images/uploaded-images/2024/07/14/233e70d4c8e7634f1958614660a5e8401720976150370356_original.jpg", listOf(SeasonStats(34, 5, 8, 2, 0, 2100))),
        PlayerResponse(2, "971570", "Endrick", "Real Madrid", 17, 60000000.0, 89.0, 45.0, "ST", "https://img.asmedia.epimg.net/resizer/v2/XCD3A5B5NJBPPBHK6X6B6NO9RE.jpg?auth=9e7297f662916d16f86230f2c8d8b67f1b25076a596706e93e230789218d6e3e&width=1200&height=675&smart=true", listOf(SeasonStats(25, 12, 3, 4, 0, 1800))),
        PlayerResponse(3, "923310", "Warren Zaïre-Emery", "PSG", 18, 60000000.0, 88.0, 35.0, "CM", "https://images.psg.media/media/208865/warren-zaire-emery.jpg?anchor=center&mode=crop&width=1200&height=800&quality=75", listOf(SeasonStats(30, 3, 5, 3, 0, 2400))),
        PlayerResponse(4, "903638", "Simone Pafundi", "Lausanne", 18, 8000000.0, 75.0, 95.0, "CAM", "https://img.legaseriea.it/v2/image?url=https%3A%2F%2Flegaseriea.it%2Fstorage%2Fplayers%2FPAFUNDI_SIMONE.png", listOf(SeasonStats(12, 1, 3, 0, 0, 450))),
        PlayerResponse(5, "1118116", "Assane Diao", "Real Betis", 18, 12000000.0, 72.0, 92.0, "LW", "https://img.asmedia.epimg.net/resizer/v2/5B5NJBPPBHK6X6B6NO9RE5B5NJ.jpg?auth=b400007915163110&width=1200&height=675&smart=true", listOf(SeasonStats(28, 4, 1, 2, 0, 1900))),
        PlayerResponse(6, "960379", "Kobbie Mainoo", "Man United", 19, 50000000.0, 87.0, 50.0, "CM", "https://assets.manutd.com/AssetManager/Images/2023/11/26/Mainoo_Action_Goodison.jpg", listOf(SeasonStats(22, 2, 2, 3, 0, 1600))),
        PlayerResponse(7, "1059588", "Pau Cubarsí", "FC Barcelona", 17, 30000000.0, 86.0, 60.0, "CB", "https://img.asmedia.epimg.net/resizer/v2/H6B6NO9RE5B5NJBPPBHK6X6B6N.jpg?auth=462911a8865c959328865e9328865g9328865h9328865i9328865j93&width=1200&height=675&smart=true", listOf(SeasonStats(18, 0, 1, 2, 0, 1500))),
        PlayerResponse(8, "1165157", "Francesco Camarda", "AC Milan", 16, 10000000.0, 65.0, 98.0, "ST", "https://img.asmedia.epimg.net/resizer/v2/5B5NJBPPBHK6X6B6NO9RE5B5NJ.jpg", listOf(SeasonStats(5, 0, 0, 0, 0, 60))),
        PlayerResponse(9, "713444", "Jobe Bellingham", "Sunderland", 18, 12000000.0, 70.0, 88.0, "CM", "https://safc.com/players/jobe-bellingham", listOf(SeasonStats(40, 7, 1, 5, 0, 3200))),
        PlayerResponse(10, "1157850", "Franco Mastantuono", "River Plate", 16, 10000000.0, 68.0, 94.0, "CAM", "https://www.cariverplate.com.ar/img/noticias/mastantuono-renovo-su-contrato-1711379464.jpg", listOf(SeasonStats(15, 2, 2, 1, 0, 800))),
        PlayerResponse(11, "801734", "Mathys Tel", "FC Bayern", 19, 40000000.0, 85.0, 55.0, "ST", "https://img.fcbayern.com/image/upload/t_cms-16x9/v1660143825/cms/public/images/fcbayern-com/players/profis/mathys-tel/tel-profis.jpg", listOf(SeasonStats(28, 6, 2, 1, 0, 1100))),
        PlayerResponse(12, "714981", "Alejandro Garnacho", "Man United", 19, 45000000.0, 88.0, 40.0, "LW", "https://assets.manutd.com/AssetManager/Images/2024/02/04/Garnacho_Goal_West_Ham.jpg", listOf(SeasonStats(36, 7, 4, 4, 0, 2800))),
        PlayerResponse(13, "830366", "Arda Güler", "Real Madrid", 19, 30000000.0, 86.0, 65.0, "CAM", "https://img.asmedia.epimg.net/resizer/v2/XCD3A5B5NJBPPBHK6X6B6NO9RE.jpg", listOf(SeasonStats(10, 6, 0, 0, 0, 400))),
        PlayerResponse(14, "1076939", "Estêvão Willian", "Palmeiras", 17, 30000000.0, 70.0, 97.0, "RW", "https://img.asmedia.epimg.net/resizer/v2/XCD3A5B5NJBPPBHK6X6B6NO9RE.jpg", listOf(SeasonStats(10, 3, 1, 0, 0, 700))),
        PlayerResponse(15, "924004", "Kenan Yıldız", "Juventus", 19, 30000000.0, 74.0, 91.0, "ST", "https://www.juventus.com/images/giocatori/yildiz.jpg", listOf(SeasonStats(25, 2, 1, 2, 0, 900))),
        PlayerResponse(16, "943964", "Vitor Roque", "Real Betis", 19, 30000000.0, 82.0, 75.0, "ST", "https://img.asmedia.epimg.net/resizer/v2/XCD3A5B5NJBPPBHK6X6B6NO9RE.jpg", listOf(SeasonStats(15, 2, 0, 1, 0, 600))),
        PlayerResponse(17, "1041126", "Claudio Echeverri", "River Plate", 18, 18000000.0, 80.0, 95.0, "CAM", "https://www.cariverplate.com.ar/img/noticias/echeverri-river-plate.jpg", listOf(SeasonStats(20, 3, 4, 1, 0, 1100))),
        PlayerResponse(18, "1025530", "George Ilenikhena", "Monaco", 17, 10000000.0, 78.0, 93.0, "ST", "https://www.asmonaco.com/players/george-ilenikhena/", listOf(SeasonStats(32, 8, 1, 0, 0, 1400))),
        PlayerResponse(19, "810103", "Lewis Hall", "Newcastle", 19, 18000000.0, 76.0, 70.0, "LB", "https://www.nufc.co.uk/teams/first-team/lewis-hall/", listOf(SeasonStats(18, 1, 2, 3, 0, 1200))),
        PlayerResponse(20, "1016629", "Adam Wharton", "Crystal Palace", 20, 20000000.0, 83.0, 85.0, "CM", "https://www.cpfc.co.uk/teams/first-team/adam-wharton/", listOf(SeasonStats(15, 0, 3, 2, 0, 1300)))
    )

    val events = listOf(
        ScoutEventResponse(1, "PERFORMANCE", "Lamine Yamal dominated the right wing in the last match.", "2024-06-05", players[0]),
        ScoutEventResponse(2, "TRANSFER", "Endrick has officially joined Real Madrid training.", "2024-06-04", players[1]),
        ScoutEventResponse(3, "INJURY", "Warren Zaïre-Emery suffered a minor knock.", "2024-06-03", players[2]),
        ScoutEventResponse(4, "PERFORMANCE", "Simone Pafundi scored a screamer for Lausanne.", "2024-06-02", players[3]),
        ScoutEventResponse(5, "SCOUT_REPORT", "New technical analysis available for Kobbie Mainoo.", "2024-06-01", players[5])
    )

    fun getRadar(id: Long): RadarResponse {
        return when(id) {
            1L -> RadarResponse(95, 82, 85, 96, 65, 88)
            2L -> RadarResponse(92, 90, 75, 88, 85, 80)
            7L -> RadarResponse(75, 40, 82, 70, 85, 95)
            else -> RadarResponse(85, 80, 88, 92, 70, 85)
        }
    }
}
