#Retrogram

[Retrofit](https://github.com/square/retrofit) ([Square](http://square.github.io/)) based Instagram client for Java and Android

#Download

```
<dependency>
    <groupId>com.getinch.retrogram</groupId>
    <artifactId>retrogram</artifactId>
    <version>1.0.1</version>
</dependency>
```

#Usage

First you need to acquire an access token. You can authenticate the user by displaying the standard Instagram OAuth2 login screen. You can build the url with the following method:

```
Instagram.requestOAuthUrl(final String clientId, final String redirectUri, final Scope... scopes);
```

Then you can access various Instagram endpoints (Users, Media, Comments, Likes, Tags, Locations).

```
final Instagram instagram = new Instagram(accessToken);
```

A simple user profile query would be like this:

```
final User user = instagram.getUsersEndpoint().getUser(userId);
```

#Building

If you want to hack into the code, feel free to fork the repository. Pull requests are welcome! Please make sure tests completing successfully.

```
mvn clean test -Daccess.token={your access token} -Dclient.id={your client id}
```

#License

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
