import { TokenHolder } from "./token-holder";

export interface SocialNetworkAuthenticationResult extends TokenHolder {
  isNewUser: boolean;
}
