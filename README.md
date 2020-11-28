# Magic The Gathering - Cube Drafter!

Got a cube but want to draft it with friends?  
Havent been able to find a service that allows you all to draft in realtime, together, with consistent booster packs?  

Having scoured the internet I have found plenty of ways to upload a cube list, but no multiplayer functional draft setup and as an avid MtG fan and owner of a cube I have spent hours of fun building and drafting from, I aim to solve that problem.  

These should be a 2 part project, the backend where you are currently reading this from, and a frontend UI for users to avail of.

###### Create a draft:  
``
curl localhost:8080/draft/new \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft", "cubeId":"4xl"}' -s
``

###### Join a draft:  
``
curl localhost:8080/draft/join \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft", "playerName":"Test_Player_1"}' -s
``


###### Start a draft: 
``
curl localhost:8080/draft/start -X PUT \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft"}' -s
``

###### Draft a card for a specific player:
``
curl localhost:8080/player/draft/card -X PUT \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft", "playerId":"0", "boosterPackId":"2", "cardName":"INSERT_CARD_NAME_HERE"}' -s
``

###### Get all drafts:
``
curl localhost:8080/drafts -s
``

###### Get a draft:
/draft/{id}  eg:  
``
curl localhost:8080/draft/HelloWorldDraft -s
``


###### Get all players from a draft:
``
curl localhost:8080/draft/HelloWorldDraft/players -s
``

###### Get a player from a draft:
/draft/{id}/player/{id}  eg:  
``
curl localhost:8080/draft/HelloWorldDraft/player/0 -s
``

###### Get all booster packs from a draft:
``
curl localhost:8080/draft/HelloWorldDraft/boosterPacks -s
``

###### Get booster pack from a draft:
/draft/{id}/boosterPack/{id}  eg:  
``
curl localhost:8080/draft/HelloWorldDraft/boosterPack/0 -s
``
