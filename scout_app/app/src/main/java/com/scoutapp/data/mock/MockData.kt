package com.scoutapp.data.mock

import com.scoutapp.data.api.PlayerResponse
import com.scoutapp.data.api.RadarResponse
import com.scoutapp.data.api.SeasonStats
import com.scoutapp.data.api.ScoutEventResponse

object MockData {
    val players = listOf(
        PlayerResponse(id = 1, transfermarktId = "1110474", name = "Lamine Yamal", club = "FC Barcelona", age = 16, marketValue = 120000000.0, marketValueDisplay = "120.0M€", talentScore = 92.0, hiddenGemScore = 40.0, position = "RW", photoUrl = "https://feeds.abplive.com/onecms/images/uploaded-images/2024/07/14/233e70d4c8e7634f1958614660a5e8401720976150370356_original.jpg", isRetired = false, statistics = listOf(SeasonStats(34, 5, 8, 2, 0, 2100))),
        PlayerResponse(id = 2, transfermarktId = "971570", name = "Endrick", club = "Real Madrid", age = 17, marketValue = 60000000.0, marketValueDisplay = "60.0M€", talentScore = 89.0, hiddenGemScore = 45.0, position = "ST", photoUrl = "https://img.asmedia.epimg.net/resizer/v2/XCD3A5B5NJBPPBHK6X6B6NO9RE.jpg?auth=9e7297f662916d16f86230f2c8d8b67f1b25076a596706e93e230789218d6e3e&width=1200&height=675&smart=true", isRetired = false, statistics = listOf(SeasonStats(25, 12, 3, 4, 0, 1800))),
        PlayerResponse(id = 3, transfermarktId = "923310", name = "Warren Zaïre-Emery", club = "PSG", age = 18, marketValue = 60000000.0, marketValueDisplay = "60.0M€", talentScore = 88.0, hiddenGemScore = 35.0, position = "CM", photoUrl = "https://images.psg.media/media/208865/warren-zaire-emery.jpg?anchor=center&mode=crop&width=1200&height=800&quality=75", isRetired = false, statistics = listOf(SeasonStats(30, 3, 5, 3, 0, 2400))),
        PlayerResponse(id = 4, transfermarktId = "903638", name = "Simone Pafundi", club = "Lausanne", age = 18, marketValue = 8000000.0, marketValueDisplay = "8.0M€", talentScore = 75.0, hiddenGemScore = 95.0, position = "CAM", photoUrl = "https://img.legaseriea.it/v2/image?url=https%3A%2F%2Flegaseriea.it%2Fstorage%2Fplayers%2FPAFUNDI_SIMONE.png", isRetired = false, statistics = listOf(SeasonStats(12, 1, 3, 0, 0, 450))),
        PlayerResponse(id = 5, transfermarktId = "1118116", name = "Assane Diao", club = "Real Betis", age = 18, marketValue = 12000000.0, marketValueDisplay = "12.0M€", talentScore = 72.0, hiddenGemScore = 92.0, position = "LW", photoUrl = "https://img.asmedia.epimg.net/resizer/v2/5B5NJBPPBHK6X6B6NO9RE5B5NJ.jpg?auth=b400007915163110&width=1200&height=675&smart=true", isRetired = false, statistics = listOf(SeasonStats(28, 4, 1, 2, 0, 1900))),
        PlayerResponse(id = 6, transfermarktId = "960379", name = "Kobbie Mainoo", club = "Man United", age = 19, marketValue = 50000000.0, talentScore = 87.0, hiddenGemScore = 50.0, position = "CM", photoUrl = "https://assets.manutd.com/AssetManager/Images/2023/11/26/Mainoo_Action_Goodison.jpg", isRetired = false, statistics = listOf(SeasonStats(22, 2, 2, 3, 0, 1600))),
        PlayerResponse(id = 7, transfermarktId = "1059588", name = "Pau Cubarsí", club = "FC Barcelona", age = 17, marketValue = 30000000.0, talentScore = 86.0, hiddenGemScore = 60.0, position = "CB", photoUrl = "https://img.asmedia.epimg.net/resizer/v2/H6B6NO9RE5B5NJBPPBHK6X6B6N.jpg?auth=462911a8865c959328865e9328865g9328865h9328865i9328865j93&width=1200&height=675&smart=true", isRetired = false, statistics = listOf(SeasonStats(18, 0, 1, 2, 0, 1500))),
        PlayerResponse(id = 8, transfermarktId = "1165157", name = "Francesco Camarda", club = "AC Milan", age = 16, marketValue = 10000000.0, talentScore = 65.0, hiddenGemScore = 98.0, position = "ST", photoUrl = "https://img.asmedia.epimg.net/resizer/v2/5B5NJBPPBHK6X6B6NO9RE5B5NJ.jpg", isRetired = false, statistics = listOf(SeasonStats(5, 0, 0, 0, 0, 60))),
        PlayerResponse(id = 9, transfermarktId = "713444", name = "Jobe Bellingham", club = "Sunderland", age = 18, marketValue = 12000000.0, talentScore = 70.0, hiddenGemScore = 88.0, position = "CM", photoUrl = "https://safc.com/players/jobe-bellingham", isRetired = false, statistics = listOf(SeasonStats(40, 7, 1, 5, 0, 3200))),
        PlayerResponse(id = 10, transfermarktId = "1157850", name = "Franco Mastantuono", club = "River Plate", age = 16, marketValue = 10000000.0, talentScore = 68.0, hiddenGemScore = 94.0, position = "CAM", photoUrl = "https://www.cariverplate.com.ar/img/noticias/mastantuono-renovo-su-contrato-1711379464.jpg", isRetired = false, statistics = listOf(SeasonStats(15, 2, 2, 1, 0, 800))),
        PlayerResponse(id = 11, transfermarktId = "801734", name = "Mathys Tel", club = "FC Bayern", age = 19, marketValue = 40000000.0, talentScore = 85.0, hiddenGemScore = 55.0, position = "ST", photoUrl = "https://img.fcbayern.com/image/upload/t_cms-16x9/v1660143825/cms/public/images/fcbayern-com/players/profis/mathys-tel/tel-profis.jpg", isRetired = false, statistics = listOf(SeasonStats(28, 6, 2, 1, 0, 1100))),
        PlayerResponse(id = 12, transfermarktId = "714981", name = "Alejandro Garnacho", club = "Man United", age = 19, marketValue = 45000000.0, talentScore = 88.0, hiddenGemScore = 40.0, position = "LW", photoUrl = "https://assets.manutd.com/AssetManager/Images/2024/02/04/Garnacho_Goal_West_Ham.jpg", isRetired = false, statistics = listOf(SeasonStats(36, 7, 4, 4, 0, 2800))),
        PlayerResponse(id = 13, transfermarktId = "830366", name = "Arda Güler", club = "Real Madrid", age = 19, marketValue = 30000000.0, talentScore = 86.0, hiddenGemScore = 65.0, position = "CAM", photoUrl = "https://img.asmedia.epimg.net/resizer/v2/XCD3A5B5NJBPPBHK6X6B6NO9RE.jpg", isRetired = false, statistics = listOf(SeasonStats(10, 6, 0, 0, 0, 400))),
        PlayerResponse(id = 14, transfermarktId = "1076939", name = "Estêvão Willian", club = "Palmeiras", age = 17, marketValue = 30000000.0, talentScore = 70.0, hiddenGemScore = 97.0, position = "RW", photoUrl = "https://img.asmedia.epimg.net/resizer/v2/XCD3A5B5NJBPPBHK6X6B6NO9RE.jpg", isRetired = false, statistics = listOf(SeasonStats(10, 3, 1, 0, 0, 700))),
        PlayerResponse(id = 15, transfermarktId = "924004", name = "Kenan Yıldız", club = "Juventus", age = 19, marketValue = 30000000.0, talentScore = 74.0, hiddenGemScore = 91.0, position = "ST", photoUrl = "https://www.juventus.com/images/giocatori/yildiz.jpg", isRetired = false, statistics = listOf(SeasonStats(25, 2, 1, 2, 0, 900))),
        PlayerResponse(id = 16, transfermarktId = "943964", name = "Vitor Roque", club = "Real Betis", age = 19, marketValue = 30000000.0, talentScore = 82.0, hiddenGemScore = 75.0, position = "ST", photoUrl = "https://img.asmedia.epimg.net/resizer/v2/XCD3A5B5NJBPPBHK6X6B6NO9RE.jpg", isRetired = false, statistics = listOf(SeasonStats(15, 2, 0, 1, 0, 600))),
        PlayerResponse(id = 17, transfermarktId = "1041126", name = "Claudio Echeverri", club = "River Plate", age = 18, marketValue = 18000000.0, talentScore = 80.0, hiddenGemScore = 95.0, position = "CAM", photoUrl = "https://www.cariverplate.com.ar/img/noticias/echeverri-river-plate.jpg", isRetired = false, statistics = listOf(SeasonStats(20, 3, 4, 1, 0, 1100))),
        PlayerResponse(id = 18, transfermarktId = "1025530", name = "George Ilenikhena", club = "Monaco", age = 17, marketValue = 10000000.0, talentScore = 78.0, hiddenGemScore = 93.0, position = "ST", photoUrl = "https://www.asmonaco.com/players/george-ilenikhena/", isRetired = false, statistics = listOf(SeasonStats(32, 8, 1, 0, 0, 1400))),
        PlayerResponse(id = 19, transfermarktId = "810103", name = "Lewis Hall", club = "Newcastle", age = 19, marketValue = 18000000.0, talentScore = 76.0, hiddenGemScore = 70.0, position = "LB", photoUrl = "https://www.nufc.co.uk/teams/first-team/lewis-hall/", isRetired = false, statistics = listOf(SeasonStats(18, 1, 2, 3, 0, 1200))),
        PlayerResponse(id = 20, transfermarktId = "1016629", name = "Adam Wharton", club = "Crystal Palace", age = 20, marketValue = 20000000.0, talentScore = 83.0, hiddenGemScore = 85.0, position = "CM", photoUrl = "https://www.cpfc.co.uk/teams/first-team/adam-wharton/", isRetired = false, statistics = listOf(SeasonStats(15, 0, 3, 2, 0, 1300)))
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
