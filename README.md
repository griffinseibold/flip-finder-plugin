# Flip Finder RuneLite plugin

Sends your Old School RuneScape account's details to your own
[Flip Finder](https://github.com/griffinseibold/Flip-Finder) server, so it can
suggest Grand Exchange flips that fit your account instead of asking for a
budget and filters:

- whether the account is a member, and how many membership days are left
- whether it is an ironman, which cannot use the Grand Exchange
- the coins and platinum tokens in your inventory and, once you open it, your
  bank
- your Grand Exchange offers
- how many of each item you have bought in its current four-hour buy limit
  window

It sends nothing until you turn it on, and then only to the server you set.
The server is the homelab version of Flip Finder; see its
[setup instructions](https://github.com/griffinseibold/Flip-Finder#run-it-on-the-homelab).

## Installing

In RuneLite, open **Configuration**, then **Plugin Hub**, search for
**Flip Finder** and select **Install**.

> The plugin has not been submitted to the Plugin Hub yet. Until it is, run
> it from source as described under [Development](#development).

## Setting it up

In RuneLite's configuration, open **Flip Finder**:

1. Check **Server URL**. The default, `http://flipfinder.localhost:8080`, is
   Flip Finder on the homelab.
2. Turn on **Send account data** and accept RuneLite's warning.
3. Open your bank once so the plugin can see the coins in it.

The plugin sends an update within ten seconds of a change, and every five
minutes otherwise.

## What it can and cannot see

- **Bank coins** are only readable while the bank is open, so the plugin
  remembers the last amount it saw.
- **Buy limits** count purchases the plugin sees. Offers that fill while you
  are logged out are counted when you next log in, as if bought then. The
  first time the plugin runs, fills of offers already in your slots count from
  that login. Purchases made on another device while the plugin is not running
  are missed if the offer is collected there.
- Some items share one limit, such as the doses of a potion. The plugin counts
  each item separately.

## Privacy

The plugin sends your account's RuneLite hash and display name with the
details above, over HTTP, to the server you configure, and to nowhere else.
Point it only at a server you run.

## Development

The plugin is based on RuneLite's
[example plugin](https://github.com/runelite/example-plugin) and targets Java
11. The Gradle wrapper needs JDK 17 or newer to run.

```bash
./gradlew build   # compile and run the tests
./gradlew run     # start a development RuneLite with the plugin loaded
```

To log in to the development client with a Jagex account, follow RuneLite's
[Using Jagex Accounts](https://github.com/runelite/runelite/wiki/Using-Jagex-Accounts)
guide.

## License

[BSD 2-Clause](LICENSE), as the RuneLite Plugin Hub requires.
