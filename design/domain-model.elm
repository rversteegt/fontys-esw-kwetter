-- module Core

type alias User = {
    profile   : Profile,
    followers : List User,
    following : List User,
    tweets    : List Tweet
}

type alias Profile = {
    name     : Name String,
    location : Location String,
    web      : Web String,
    bio      : Bio String,
    picture  : Picture
}

type alias Picture = {
    mimeType : Mimetype String String,
    fileName : FileName String,
    data     : Base64 String
}

type alias Tweet = {
    message   : Message,
    timestamp : Timestamp
}


addTweet      : User -> Tweet -> User
addFollower   : User -> User -> User
updateProfile : User -> Profile -> User


-- module History

search   : SearchTerm String -> List Tweet
timeline : User -> List Tweet
mentions : User -> List Tweet


-- module Trends

listHastags          : () -> List Hashtag
viewTweetsWithHastag : Hashtag -> List Tweet


-- module Auth

type alias Credentials = {
    username : Username String,
    password : Password String
}

type User = AuthenticatedUser | UnauthenticatedUser


login  : UnauthenticatedUser -> Credentials -> AuthenticatedUser
logout : AuthenticatedUser -> UnauthenticatedUser