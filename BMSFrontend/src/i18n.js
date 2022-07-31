import i18n from "i18next";
import { initReactI18next } from "react-i18next";

import translationEnglish from "./locales/en/translation.json";
// import translationCzech from "./locales/cs/translation.json";
// import translationGerman from "./locales/de/translation.json";
// import translationSpanish from "./locales/es/translation.json";
import translationFrench from "./locales/fr/translation.json";
// import translationHungarian from "./locales/hu/translation.json";
// import translationItalian from "./locales/it/translation.json";
// import translationJapanese from "./locales/ja/translation.json";
// import translationKorean from "./locales/ko/translation.json";
// import translationPolish from "./locales/pl/translation.json";
// import translationPortuguese_Brazil from "./locales/pt/BR/translation.json";
// import translationRussian from "./locales/ru/translation.json";
// import translationTurkish from "./locales/tr/translation.json";
// import translationChinese from "./locales/zh/translation.json";
// import translationChinese_Taiwan from "./locales/zh/TW/translation.json";
// import translationChinese_HongKong from "./locales/zh/HK/translation.json";

// the translations
const resources = {
  en: {
    translation: translationEnglish
  },  
  fr: {
    translation: translationFrench
  }
};

i18n
  .use(initReactI18next) // passes i18n down to react-i18next
  .init({
    resources,
    lng: "en",
    fallbackLng: "en",
    keySeparator: false, // we do not use keys in form messages.welcome

    interpolation: {
      escapeValue: false // react already safes from xss
    }
  });

export default i18n;
