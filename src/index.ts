import { NativeModules, NativeEventEmitter,requireNativeComponent,UIManager,ViewStyle } from 'react-native';
import type { FaceRecognitionInterface, InitConfig, FaceDetectionResult } from './types';

 const LINKING_ERROR =
   `The package 'react-native-face-recognition' doesn't seem to be linked. Make sure: \n\n` +
   '- You rebuilt the app after installing the package\n' +
   '- You are not using Expo Go\n';

type FaceRecognitionProps = {
  color?: string; // 示例 Prop
  style?:ViewStyle;
};

const ComponentName = 'FaceRecognitionView';

// requireNativeComponent 是连接原生视图和 React 组件的魔法
// 它会根据 ComponentName 找到对应的 ViewManager
export const FaceAISDKView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<FaceRecognitionProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      }

const { FaceAISDK } = NativeModules;
const faceRecognitionEmitter = new NativeEventEmitter(FaceAISDK);

export const FaceRecognitionAPI: FaceRecognitionInterface = {
  initializeSDK: (config: InitConfig) => FaceAISDK.initializeSDK(config),
  detectFace: (imagePath: string) => FaceAISDK.detectFace(imagePath),
  addFace: (imagePath: string) => FaceAISDK.addFace(imagePath),
};

// 可选：监听原生事件
export const subscribeToEvents = (callback: (event: any) => void) => {
  return faceRecognitionEmitter.addListener('FaceRecognitionEvent', callback);
};

export type { InitConfig, FaceDetectionResult };