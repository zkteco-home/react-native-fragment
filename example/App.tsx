/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */
import { useState, useEffect, useRef } from 'react';
import {
  StatusBar,
  StyleSheet,
  useColorScheme,
  View,
  Text,

} from 'react-native';
import {
  SafeAreaProvider,
  useSafeAreaInsets,
} from 'react-native-safe-area-context';

import {
  FaceAISDKView,
} from 'react-native-face-recognition';
const COLORS = {
  light: {
    background: '#f3f3f3',
    backgroundHighlight: '#cfe6ee',
    cardBackground: '#fff',
    cardOutline: '#dae1e7',
    textPrimary: '#000',
    textSecondary: '#404756',
  },
  dark: {
    background: '#000',
    backgroundHighlight: '#193c47',
    cardBackground: '#222',
    cardOutline: '#444',
    textPrimary: '#fff',
    textSecondary: '#c0c1c4',
  },
};


function App() {
  const [result, setResult] = useState<any>(null);




  const isDarkMode = useColorScheme() === 'dark';

  useEffect(() => {
  }, []);


  return (
  <View style={styles.container}>

      <View style={styles.header}>
        <Text style={styles.title}>Welcome to React Native</Text>
      </View>
      <FaceAISDKView style={styles.box} />
  </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
     alignItems: 'center',
      paddingHorizontal: 24,
  },
  header: {
    width: '100%',
    alignItems: 'center',
    marginTop: 64,
    marginBottom: 48,
  },
  title: {
    fontSize: 24,
    fontWeight: '600',
    marginBottom: 24,
  },

  box: {
    width:300,
    height:300,
    borderWidth:1,
    backgroundColor: 'black',
  },
});

export default App;
