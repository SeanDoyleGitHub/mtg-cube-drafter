# Magic The Gathering - Cube Drafter!

Got a cube but want to draft it with friends?  
Havent been able to find a service that allows you all to draft in realtime, together, with consistent booster packs?  

Having scoured the internet I have found plenty of ways to upload a cube list, but no multiplayer functional draft setup and as an avid MtG fan and owner of a cube I have spent hours of fun building and drafting from, I aim to solve that problem.  

These should be a 2 part project, the backend where you are currently reading this from, and a frontend UI for users to avail of.

#### Create a draft:  
``
curl localhost:8080/draft/new \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft", "cubeId":"4xl"}' -s
``

#### Join a draft:  
``
curl localhost:8080/draft/join \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft", "playerName":"Test_Player_1"}' -s
``


#### Start a draft: 
``
curl localhost:8080/draft/start -X PUT \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft"}' -s
``
