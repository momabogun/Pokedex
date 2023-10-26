# Pokédex App

The Pokédex app is an Android application that serves as an interactive Pokédex, allowing users to browse and discover information about various Pokémon. This app is built using Kotlin, follows the MVVM architectural pattern, uses Room Database for local data storage, and fetches data from the Poke API with Moshi for JSON parsing.

## Features

- View a list of first 200 Pokémon.
- Search for Pokémon by name.
- View detailed information about each Pokémon.

## Screenshots

![Screenshot 1](src/main/res/drawable/pokemonReadme.png)

## Libraries Used

- Android Architecture Components (ViewModel, LiveData)
- Room Database
- Retrofit for network requests
- Moshi for JSON parsing
- Coil for image loading
- Material Design components for UI

## Setup

To build and run this app, follow these steps:

1. Clone this repository to your local machine.

2. Open the project in Android Studio.

3. Make sure you have the necessary dependencies in your app-level build.gradle file, as mentioned in the project setup section.

4. Run the app on an emulator or physical Android device.

## Usage

- Upon launching the app, you'll be presented with loading screen (can take a little bit longer, depends on Api latency), which will lead you to list of Pokemons.
- You can use the search bar to find a specific Pokémon by name.
- Click on a Pokémon to view detailed information.

## Data Storage

Pokémon data is stored locally using Room Database to provide offline access to previously viewed Pokémon.

## API Integration

The app fetches data from the [Poke API](https://pokeapi.co/), an open-source Pokémon data API. Retrofit is used for making API requests, and Moshi is employed for parsing the JSON responses.

## Contributors

- [Momcilo Bogunovic](https://github.com/momabogun)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- The Pokédex app was developed with the support of the Android community and various open-source libraries.

## Support

If you encounter any issues or have questions about the app, please [open an issue](https://github.com/momabogun/issues) on GitHub.
