import { SocialNetworkType } from "./social-network-type";

export interface SocialNetworkAuthenticationParams {
  code: string;
  redirectUri: string;
  socialNetworkType: SocialNetworkType;
}
