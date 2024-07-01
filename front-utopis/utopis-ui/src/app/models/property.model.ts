export interface Property {
    id?: string,
    name?: string,
    description?: string,
    propertyType?: PropertyType,
    address?: Address,
    price?: number,
    numberOfRooms?: number,
    numberOfBathrooms?: number,
    availability?: Date,
    rating?: number,
    createdAt?: Date,
    reviews?: Array<string>
}

export enum PropertyType {
    HOUSE,
    APARTMENT,
    TOWNHOUSE,
    STUDIO,
    LOFT,
    CABIN,
    VILLA,
    BUNGALOW,
    TENT
}

export interface Address {
    address1?: string,
    address2?: string,
    city?: string,
    postalCode?: string
}