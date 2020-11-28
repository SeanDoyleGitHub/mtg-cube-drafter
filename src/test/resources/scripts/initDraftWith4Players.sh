curl localhost:8080/draft/new \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft", "cubeId":"4xl"}' -s

curl localhost:8080/draft/join \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft", "playerName":"Test_Player_1"}' -s

curl localhost:8080/draft/join \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft", "playerName":"Test_Player_2"}' -s

curl localhost:8080/draft/join \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft", "playerName":"Test_Player_3"}' -s

curl localhost:8080/draft/join \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft", "playerName":"Test_Player_4"}' -s

curl localhost:8080/draft/start -X PUT \
--header "Content-Type: application/json" \
--data '{"draftId":"HelloWorldDraft"}' -s
