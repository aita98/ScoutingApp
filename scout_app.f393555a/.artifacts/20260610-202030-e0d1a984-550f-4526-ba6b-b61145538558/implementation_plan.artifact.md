# Finish Transfermarkt Repository Implementation in Backend

The goal is to centralize the Transfermarkt API integration in the backend by creating a dedicated `TransfermarktRepository` and refactoring the controllers to use it. This will also involve adding missing endpoints to the `TransfermarktClient` and improving data mapping.

## User Review Required

- **Naming Convention**: I am using the name `TransfermarktRepository` as requested, although in Spring Boot it functions more as a service/remote data source.
- **Data Persistence**: Currently, the `PlayerController` saves TM search results to the local database. I will maintain this behavior but move it to the `TransfermarktRepository`.

## Proposed Changes

### [Backend] API Client and DTOs

#### [TransfermarktClient.java](file:///D:/Progetti/FootballScouting/backend/src/main/java/com/scoutapp/client/TransfermarktClient.java)
- Add missing endpoints: `getTransfers`, `getJerseyNumbers`, `getInjuries`, `getAchievements`.
- Refactor return types from `Map<String, Object>` to specific DTOs.

#### [NEW] [TransfermarktDtos.java](file:///D:/Progetti/FootballScouting/backend/src/main/java/com/scoutapp/dto/transfermarkt/TransfermarktDtos.java)
- Define Java DTOs for Transfermarkt API responses (Search, Profile, Stats, Club Players, etc.) matching the structures in the Python API.

---

### [Backend] Repository Layer

#### [NEW] [TransfermarktRepository.java](file:///D:/Progetti/FootballScouting/backend/src/main/java/com/scoutapp/repository/TransfermarktRepository.java)
- Centralize logic for:
    - Searching players and mapping to `Player` entities.
    - Fetching and syncing player profiles and stats.
    - Fetching teams for a competition.
    - Fetching players for a club.
- Handle data persistence (saving/updating `Player` and `PlayerStats` entities).

---

### [Backend] Controller Refactoring

#### [PlayerController.java](file:///D:/Progetti/FootballScouting/backend/src/main/java/com/scoutapp/controller/PlayerController.java)
- Remove manual TM mapping logic.
- Inject and use `TransfermarktRepository` for search and sync operations.

#### [CompetitionController.java](file:///D:/Progetti/FootballScouting/backend/src/main/java/com/scoutapp/controller/CompetitionController.java)
- Inject and use `TransfermarktRepository` for league and team operations.

---

### [Backend] Sync Service

#### [DataSyncService.java](file:///D:/Progetti/FootballScouting/backend/src/main/java/com/scoutapp/service/DataSyncService.java)
- Add a new method `syncWithTransfermarkt` to allow bulk syncing of players using TM data.

---

### [Python API] Fix Dependencies (Optional/Best Effort)

- Try to install dependencies using `PYO3_USE_ABI3_FORWARD_COMPATIBILITY=1` for `pydantic-core` and `watchfiles`.
- Investigate missing `libxml2` headers for `lxml`.

## Verification Plan

### Automated Tests
- Since it's a refactoring of existing logic, I will verify that the endpoints still return the same (or improved) data.
- Run `mvn clean compile` to ensure no regressions in build.

### Manual Verification
- Test `GET /api/players/search?query=...` and verify results are populated and saved.
- Test `POST /api/players/{id}/sync-tm` and verify profile and stats are updated.
- Test `GET /api/leagues/{id}/teams` and `GET /api/leagues/team/{teamId}/players`.
