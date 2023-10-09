import mongoose, { Document, Model, Schema } from "mongoose";

export interface ICompany extends Document {
  companyName: string;
  phoneNumber: string;
  companyEmail: string;
  storeManagementCount: number;
  companyPw: string;
  points: number;
  refreshToken: string;
}

const companySchema: Schema<ICompany> = new Schema(
  {
    companyName: {
      type: String,
      required: true,
      unique: false,
    },
    phoneNumber: {
      type: String,
      required: true,
      unique: true,
    },
    companyEmail: {
      type: String,
      required: true,
      unique: true,
    },
    storeManagementCount: {
      type: Number,
      required: true,
      unique: false,
    },
    companyPw: {
      type: String,
      required: true,
      unique: false,
    },
    points: {
      type: Number,
      required: false,
      default: 0,
    },
    refreshToken: {
      type: String,
      required: false,
    },
  },
  { timestamps: true }
);

const Company: Model<ICompany> = mongoose.model<ICompany>("Company", companySchema);

export default Company;
