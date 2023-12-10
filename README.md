# kameleoon-test

Test task for Kameleoon

Endpoints: http://localhost:8080/api/v1

/admin/users POST - create new user

/admin/quotes/{quote_id} GET - get quote

/admin/quotes/{quote_id}/evolution GET - get ratings evoluton for quote

/users/{user_id}/quotes POST - create new quote

/users/{user_id}/quotes/{quote_id}/votes POST - create new vote (true - upvote, false - downvote)

/quotes/all GET - get all quotes (default first 10 quotes)

/quotes/random GET - get random quote

/quotes/top GET - get 10 top quotes

/quotes/worse GET - get 10 worse quotes
