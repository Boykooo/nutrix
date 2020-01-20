import { Credentials }         from "./credentials";
import { AccountPhysicalData } from "./account-physical-data";

/**
 * Object for registration via Username and Password
 */
export interface CredentialsRegisterData extends Credentials {
  physicalData: AccountPhysicalData;
}
