INSERT INTO users (name, email, password, created_on)
VALUES ('Santa Claus', 'santa@gmail.com', 'qwerty', '1970-01-01'),
       ('Darth Vader', 'dark_side@starwars.com', '~@#$Empire^&*', '1977-05-25'),
       ('John Silver', 'yohoho@yahoo.com', 'Caramba100500', '1750-08-08');

INSERT INTO quotes (content, created_on, speaker_id)
VALUES ('Be someone''s Santa; give ‘Fanta’!', '2000-01-01', 1),
       ('The best way to spread Christmas cheer is singing loud for all to hear.', '2000-01-01', 1),
       ('The true spirit of Christmas is love.', '2000-01-01', 1),
       ('Christmas is not as much about opening presents as it is about opening our hearts.', '2000-01-01', 1),
       ('Santa Claus has the right idea: visit people only once a year.', '2000-01-01', 1),
       ('Christmas is a season not only of rejoicing but of reflection.', '2000-01-01', 1),
       ('A hug is the perfect gift; one size fits all and nobody minds if you exchange it.', '2000-01-01', 1),
       ('Santa Claus is anyone who loves another and seeks to make them happy.', '2000-01-01', 1),
       ('Christmas waves a magic wand over this world, and behold, everything is softer and more beautiful.', '2000-01-01', 1),
       ('Let''s be naughty and save Santa the trip.', '2000-01-01', 1),
       ('God put Santa Claus on earth to remind us that Christmas is sposed to be a happy time.', '2000-01-01', 1),
       ('Christmas waves a magic wand over this world, and behold, everything is softer and more beautiful.', '2000-01-01', 1),
       ('Christmas is the season of joy, of gift-giving, and of families united.', '2000-01-01', 1),
       ('Christmas is doing a little something extra for someone.', '2000-01-01', 1),
       ('You don’t know the power of the dark side! I must obey my master.', '30000-01-01', 2),
       ('No, I am your father!', '30000-01-01', 2),
       ('This will be a day long remembered. It has seen the end of Kenobi; it will soon see the end of the Rebellion.', '30000-01-01', 2),
       ('That name no longer has any meaning for me.', '30000-01-01', 2),
       ('I am altering the deal. Pray, I don’t alter it any further.', '30000-01-01', 2),
       ('It is… too late for me, son. The Emperor will show you the true nature of the Force. He is your master now.', '30000-01-01', 2),
       ('Be careful not to choke on your aspirations.', '30000-01-01', 2),
       ('You cannot hide forever, Luke.', '30000-01-01', 2),
       ('You have controlled your fear. Now, release your anger. Only your hatred can destroy me.', '30000-01-01', 2),
       ('When I left you, I was but the learner. Now I am the master.', '30000-01-01', 2),
       ('You already have, Luke.', '30000-01-01', 2),
       ('I hope so for your sake, Commander. The Emperor is not as forgiving as I am.', '30000-01-01', 2),
       ('All I am surrounded by is fear, and dead men!', '30000-01-01', 2),
       ('If you’re not with me, then you’re my enemy!', '30000-01-01', 2),
       ('Didn''t your pap ever teach you to pick your fights a bit more carefully?', '1883-01-01', 3),
       ('Look at you! Glowing like a solar fire. You''re something special, Jim. You''re gonna rattle the stars, you are!', '1883-01-01', 3),
       ('That treasure is owed me, by ''tunder!', '1883-01-01', 3),
       ('Why, Mister Arrow, sir. Bringin'' in such fine and distinguished gents to grace my humble galley. Had I known, I''d have tucked in me shirt.', '1883-01-01', 3);

INSERT INTO votes (positive, negative, created_on, voter_id, quote_id)
VALUES (TRUE, NULL, '2023-01-01', 2, 3),
       (TRUE, NULL, '2023-01-01', 3, 3),
       (TRUE, NULL, '2023-01-01', 3, 2),
       (NULL, TRUE, '2023-01-01', 3, 1);