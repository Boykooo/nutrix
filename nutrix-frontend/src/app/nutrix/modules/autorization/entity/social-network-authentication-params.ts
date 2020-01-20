import { SocialNetworkType }   from "./social-network-type";
import { AccountPhysicalData } from "./account-physical-data";

export interface SocialNetworkAuthenticationParams {
  code: string;
  redirectUri: string;
  socialNetworkType: SocialNetworkType;
  physicalData: AccountPhysicalData;
}
